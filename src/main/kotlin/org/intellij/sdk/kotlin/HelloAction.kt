// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.intellij.sdk.kotlin

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.PlatformDataKeys
import com.intellij.openapi.ui.Messages
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HelloAction : AnAction() {
    override fun actionPerformed(event: AnActionEvent) {
        // Throw an error inside a coroutine. I expect this to be caught by the default CoroutineExceptionHandler.
        GlobalScope.launch(Dispatchers.Main) {
            error("an uncaught exception")
        }

        val project = event.getData(PlatformDataKeys.PROJECT)
        Messages.showMessageDialog(project, "Hello from Kotlin!", "Greeting", Messages.getInformationIcon())
    }

}
