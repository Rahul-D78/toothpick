/*
 * Copyright 2019 Stephane Nicolas
 * Copyright 2019 Daniel Molinero Reguera
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.toothpick.ktp

import toothpick.Scope
import toothpick.config.Module

class KTPScope(private val scope: Scope) : Scope by scope {

    override fun inject(obj: Any?) {
        obj?.let {
            KTP.delegateNotifier.notifyDelegates(it, scope)
        }
    }

    override fun installModules(vararg modules: Module?): Scope {
        scope.installModules(*modules)
        return this
    }
}