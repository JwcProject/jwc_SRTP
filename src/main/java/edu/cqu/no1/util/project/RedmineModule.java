package edu.cqu.no1.util.project;

public enum RedmineModule {

	issue_tracking {
		@Override
		public String getModuleName() {
			// TODO Auto-generated method stub
			return "issue_tracking";
		}
	}, time_tracking {
		@Override
		public String getModuleName() {
			// TODO Auto-generated method stub
			return "time_tracking";
		}
	}, news {
		@Override
		public String getModuleName() {
			// TODO Auto-generated method stub
			return "news";
		}
	}, documents {
		@Override
		public String getModuleName() {
			// TODO Auto-generated method stub
			return "documents";
		}
	}, files {
		@Override
		public String getModuleName() {
			// TODO Auto-generated method stub
			return "files";
		}
	}, wiki {
		@Override
		public String getModuleName() {
			// TODO Auto-generated method stub
			return "wiki";
		}
	}, boards {
		@Override
		public String getModuleName() {
			// TODO Auto-generated method stub
			return "boards";
		}
	}, calendar {
		@Override
		public String getModuleName() {
			// TODO Auto-generated method stub
			return "calendar";
		}
	}, gantt {
		@Override
		public String getModuleName() {
			// TODO Auto-generated method stub
			return "gantt";
		}
	}, process_frameworks {
		@Override
		public String getModuleName() {
			// TODO Auto-generated method stub
			return "process_frameworks";
		}
	};
	
	public abstract String getModuleName();
}
