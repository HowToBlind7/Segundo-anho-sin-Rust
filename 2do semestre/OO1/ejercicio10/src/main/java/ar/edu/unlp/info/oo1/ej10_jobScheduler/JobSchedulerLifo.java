package ar.edu.unlp.info.oo1.ej10_jobScheduler;

public class JobSchedulerLifo extends JobScheduler {
	
	public JobSchedulerLifo() {
		super();
	}

	@Override
	public JobDescription next() {
		if (this.jobs.isEmpty()) {
			return null;
		}
		JobDescription nextJob = jobs.get(jobs.size()-1);
        this.unschedule(nextJob);
        return nextJob;
	}
}
