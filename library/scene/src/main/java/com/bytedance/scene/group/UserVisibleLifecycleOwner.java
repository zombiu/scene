/*
 * Copyright (C) 2019 ByteDance Inc
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
package com.bytedance.scene.group;


import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;

class UserVisibleLifecycleOwner implements LifecycleOwner {
    private LifecycleRegistry mLifecycleRegistry = null;

    /**
     * Initializes the underlying Lifecycle if it hasn't already been created.
     */
    private void initialize() {
        if (mLifecycleRegistry == null) {
            mLifecycleRegistry = new LifecycleRegistry(this);
        }
    }

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        initialize();
        return mLifecycleRegistry;
    }

    void handleLifecycleEvent(@NonNull Lifecycle.Event event) {
        initialize();
        mLifecycleRegistry.handleLifecycleEvent(event);
    }
}