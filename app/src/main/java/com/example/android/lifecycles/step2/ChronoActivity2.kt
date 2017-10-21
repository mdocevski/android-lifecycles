/*
 * Copyright 2017, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.lifecycles.step2

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.os.SystemClock
import android.support.v7.app.AppCompatActivity
import com.example.android.codelabs.lifecycle.R
import kotlinx.android.synthetic.main.activity_main.*

class ChronoActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // The ViewModelStore provides a new ViewModel or one previously created.
        val chronometerViewModel = ViewModelProviders.of(this).get<ChronometerViewModel>(ChronometerViewModel::class.java)

        // Get the chronometer reference
        if (chronometerViewModel.startDate == null) {
            chronometerViewModel.startDate = SystemClock.elapsedRealtime()
        }
        chronometer.base = chronometerViewModel.startDate!!
        chronometer.start()
    }
}
