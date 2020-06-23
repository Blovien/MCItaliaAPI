package it.andrearossi.mcitaliaapi.exceptions

import it.andrearossi.mcitaliaapi.utils.DoubleRunnable

class DefaultExceptionHandler : APIExceptionHandler() {
    override fun runnableAdapter(): DoubleRunnable<ErrorCase, Exception> {
        return DoubleRunnable { errorCase: ErrorCase?, exception: Exception -> exception.printStackTrace() }
    }
}