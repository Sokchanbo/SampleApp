package chanbo.com.sampleproject.utils.rx

import io.reactivex.Scheduler

interface SchedulerProvider {

    val io: Scheduler

    val ui: Scheduler
}