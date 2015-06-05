package edu.cqu.no1.util.project;

public enum ProjectTracker {
	通知 {
		@Override
		public int getTrackersId() {
			return 4;
		}
	}, 申报 {
		@Override
		public int getTrackersId() {
			return 5;
		}
	}, 立项 {
		@Override
		public int getTrackersId() {
			return 6;
		}
	},中期检查 {
		@Override
		public int getTrackersId() {
			return 7;
		}
	},结题通知 {
		@Override
		public int getTrackersId() {
			return 8;
		}
	},申报评审 {
		@Override
		public int getTrackersId() {
			return 9;
		}
	},结题评审 {
		@Override
		public int getTrackersId() {
			return 10;
		}
	};
	
	public abstract int getTrackersId();
}
