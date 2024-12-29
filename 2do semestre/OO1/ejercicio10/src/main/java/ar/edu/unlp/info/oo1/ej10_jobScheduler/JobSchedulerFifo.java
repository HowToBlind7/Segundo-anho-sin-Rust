package ar.edu.unlp.info.oo1.ej10_jobScheduler;

public class JobSchedulerFifo extends JobScheduler {
	
	public JobSchedulerFifo() {
		super();
	}

	@Override
	public JobDescription next() {
		if (this.jobs.isEmpty()) {
			return null;
		}
		JobDescription nextJob = jobs.get(0);
        super.unschedule(nextJob);
        return nextJob;
	}
}
