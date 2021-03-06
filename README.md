A sample IntelliJ plugin that triggers an IDE level `
java.lang.NoClassDefFoundError: Could not initialize class kotlinx.coroutines.CoroutineExceptionHandlerImplKt` error when throwing an uncaught exception from a coroutine.

Error thrown [here](https://github.com/matthewmichihara/NCDFE/blob/main/src/main/kotlin/org/intellij/sdk/kotlin/HelloAction.kt#L15-L18).

Steps to reproduce
1. Run plugin: `./gradlew runIde`
2. Trigger the `Greeting` -> `Hello` action from the toolbar.

Expected:
No IDE Fatal Error occurs. The default coroutine error handler should just print the error to stderr.

Actual:
IDE Fatal Error occurs.

![image](https://user-images.githubusercontent.com/79073/132067378-55ca8dd5-47e0-4b52-8a31-5bbc29917c0e.png)


Full stacktrace:
```
java.lang.NoClassDefFoundError: Could not initialize class kotlinx.coroutines.CoroutineExceptionHandlerImplKt
	at kotlinx.coroutines.CoroutineExceptionHandlerKt.handleCoroutineException(CoroutineExceptionHandler.kt:33)
	at kotlinx.coroutines.DispatchedTask.handleFatalException$kotlinx_coroutines_core(DispatchedTask.kt:95)
	at kotlinx.coroutines.DispatchedTask.run(DispatchedTask.kt:64)
	at java.desktop/java.awt.event.InvocationEvent.dispatch(InvocationEvent.java:313)
	at java.desktop/java.awt.EventQueue.dispatchEventImpl(EventQueue.java:776)
	at java.desktop/java.awt.EventQueue$4.run(EventQueue.java:727)
	at java.desktop/java.awt.EventQueue$4.run(EventQueue.java:721)
	at java.base/java.security.AccessController.doPrivileged(Native Method)
	at java.base/java.security.ProtectionDomain$JavaSecurityAccessImpl.doIntersectionPrivilege(ProtectionDomain.java:85)
	at java.desktop/java.awt.EventQueue.dispatchEvent(EventQueue.java:746)
	at com.intellij.ide.IdeEventQueue.defaultDispatchEvent(IdeEventQueue.java:887)
	at com.intellij.ide.IdeEventQueue._dispatchEvent(IdeEventQueue.java:756)
	at com.intellij.ide.IdeEventQueue.lambda$dispatchEvent$7(IdeEventQueue.java:443)
	at com.intellij.openapi.progress.impl.CoreProgressManager.computePrioritized(CoreProgressManager.java:825)
	at com.intellij.ide.IdeEventQueue.lambda$dispatchEvent$8(IdeEventQueue.java:442)
	at com.intellij.openapi.application.impl.ApplicationImpl.runIntendedWriteActionOnCurrentThread(ApplicationImpl.java:794)
	at com.intellij.ide.IdeEventQueue.dispatchEvent(IdeEventQueue.java:494)
	at java.desktop/java.awt.EventDispatchThread.pumpOneEventForFilters(EventDispatchThread.java:203)
	at java.desktop/java.awt.EventDispatchThread.pumpEventsForFilter(EventDispatchThread.java:124)
	at java.desktop/java.awt.EventDispatchThread.pumpEventsForFilter(EventDispatchThread.java:117)
	at java.desktop/java.awt.WaitDispatchSupport$2.run(WaitDispatchSupport.java:190)
	at java.desktop/java.awt.WaitDispatchSupport$4.run(WaitDispatchSupport.java:235)
	at java.desktop/java.awt.WaitDispatchSupport$4.run(WaitDispatchSupport.java:233)
	at java.base/java.security.AccessController.doPrivileged(Native Method)
	at java.desktop/java.awt.WaitDispatchSupport.enter(WaitDispatchSupport.java:233)
	at java.desktop/java.awt.Dialog.show(Dialog.java:1063)
	at com.intellij.openapi.ui.impl.DialogWrapperPeerImpl$MyDialog.show(DialogWrapperPeerImpl.java:699)
	at com.intellij.openapi.ui.impl.DialogWrapperPeerImpl.show(DialogWrapperPeerImpl.java:435)
	at com.intellij.openapi.ui.DialogWrapper.doShow(DialogWrapper.java:1726)
	at com.intellij.openapi.ui.DialogWrapper.show(DialogWrapper.java:1685)
	at com.intellij.openapi.ui.messages.AlertMessagesManager.showMessageDialog(AlertMessagesManager.kt:117)
	at com.intellij.ui.messages.MessagesServiceImpl.showMessageDialog(MessagesServiceImpl.java:58)
	at com.jetbrains.rdserver.ui.BackendMessagesService.showMessageDialog(BackendMessagesService.kt:28)
	at com.intellij.openapi.ui.Messages.showDialog(Messages.java:212)
	at com.intellij.openapi.ui.Messages.showDialog(Messages.java:168)
	at com.intellij.openapi.ui.Messages.showMessageDialog(Messages.java:337)
	at org.intellij.sdk.kotlin.HelloAction.actionPerformed(HelloAction.kt:21)
	at com.intellij.openapi.actionSystem.ex.ActionUtil.lambda$performActionDumbAwareWithCallbacks$4(ActionUtil.java:240)
	at com.intellij.openapi.actionSystem.ex.ActionUtil.performDumbAwareWithCallbacks(ActionUtil.java:261)
	at com.intellij.openapi.actionSystem.ex.ActionUtil.performActionDumbAwareWithCallbacks(ActionUtil.java:240)
	at com.intellij.openapi.actionSystem.impl.ActionMenuItem$ActionTransmitter.lambda$actionPerformed$0(ActionMenuItem.java:248)
	at com.intellij.openapi.wm.impl.FocusManagerImpl.runOnOwnContext(FocusManagerImpl.java:236)
	at com.intellij.openapi.wm.impl.IdeFocusManagerImpl.runOnOwnContext(IdeFocusManagerImpl.java:67)
	at com.intellij.openapi.actionSystem.impl.ActionMenuItem$ActionTransmitter.actionPerformed(ActionMenuItem.java:240)
	at java.desktop/javax.swing.AbstractButton.fireActionPerformed(AbstractButton.java:1967)
	at com.intellij.openapi.actionSystem.impl.ActionMenuItem.lambda$fireActionPerformed$0(ActionMenuItem.java:90)
	at com.intellij.openapi.application.TransactionGuardImpl.performUserActivity(TransactionGuardImpl.java:94)
	at com.intellij.openapi.actionSystem.impl.ActionMenuItem.fireActionPerformed(ActionMenuItem.java:90)
	at java.desktop/javax.swing.AbstractButton$Handler.actionPerformed(AbstractButton.java:2308)
	at java.desktop/javax.swing.DefaultButtonModel.fireActionPerformed(DefaultButtonModel.java:405)
	at java.desktop/javax.swing.JToggleButton$ToggleButtonModel.setPressed(JToggleButton.java:401)
	at java.desktop/javax.swing.AbstractButton.doClick(AbstractButton.java:369)
	at java.desktop/com.apple.laf.ScreenMenuItemCheckbox.itemStateChanged(ScreenMenuItemCheckbox.java:204)
	at java.desktop/java.awt.CheckboxMenuItem.processItemEvent(CheckboxMenuItem.java:396)
	at java.desktop/java.awt.CheckboxMenuItem.processEvent(CheckboxMenuItem.java:364)
	at java.desktop/java.awt.MenuComponent.dispatchEventImpl(MenuComponent.java:375)
	at java.desktop/java.awt.MenuComponent.dispatchEvent(MenuComponent.java:363)
	at java.desktop/java.awt.EventQueue.dispatchEventImpl(EventQueue.java:781)
	at java.desktop/java.awt.EventQueue$4.run(EventQueue.java:727)
	at java.desktop/java.awt.EventQueue$4.run(EventQueue.java:721)
	at java.base/java.security.AccessController.doPrivileged(Native Method)
	at java.base/java.security.ProtectionDomain$JavaSecurityAccessImpl.doIntersectionPrivilege(ProtectionDomain.java:85)
	at java.base/java.security.ProtectionDomain$JavaSecurityAccessImpl.doIntersectionPrivilege(ProtectionDomain.java:95)
	at java.desktop/java.awt.EventQueue$5.run(EventQueue.java:751)
	at java.desktop/java.awt.EventQueue$5.run(EventQueue.java:749)
	at java.base/java.security.AccessController.doPrivileged(Native Method)
	at java.base/java.security.ProtectionDomain$JavaSecurityAccessImpl.doIntersectionPrivilege(ProtectionDomain.java:85)
	at java.desktop/java.awt.EventQueue.dispatchEvent(EventQueue.java:748)
	at com.intellij.ide.IdeEventQueue.defaultDispatchEvent(IdeEventQueue.java:887)
	at com.intellij.ide.IdeEventQueue._dispatchEvent(IdeEventQueue.java:756)
	at com.intellij.ide.IdeEventQueue.lambda$dispatchEvent$7(IdeEventQueue.java:443)
	at com.intellij.openapi.progress.impl.CoreProgressManager.computePrioritized(CoreProgressManager.java:825)
	at com.intellij.ide.IdeEventQueue.lambda$dispatchEvent$8(IdeEventQueue.java:442)
	at com.intellij.openapi.application.impl.ApplicationImpl.runIntendedWriteActionOnCurrentThread(ApplicationImpl.java:794)
	at com.intellij.ide.IdeEventQueue.dispatchEvent(IdeEventQueue.java:494)
	at java.desktop/java.awt.EventDispatchThread.pumpOneEventForFilters(EventDispatchThread.java:203)
	at java.desktop/java.awt.EventDispatchThread.pumpEventsForFilter(EventDispatchThread.java:124)
	at java.desktop/java.awt.EventDispatchThread.pumpEventsForHierarchy(EventDispatchThread.java:113)
	at java.desktop/java.awt.EventDispatchThread.pumpEvents(EventDispatchThread.java:109)
	at java.desktop/java.awt.EventDispatchThread.pumpEvents(EventDispatchThread.java:101)
	at java.desktop/java.awt.EventDispatchThread.run(EventDispatchThread.java:90)
  ```
