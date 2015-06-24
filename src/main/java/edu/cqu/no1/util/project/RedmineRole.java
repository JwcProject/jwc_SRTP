package edu.cqu.no1.util.project;

public enum RedmineRole {
	Nonmember {
		@Override
		public int getRoleId() {
			return 1;
		}
	}, 
	Anonymous {
		@Override
		public int getRoleId() {
			return 2;
		}
	}, 
	管理人员 {
		@Override
		public int getRoleId() {
			return 3;
		}
	}, 
	开发人员 {
		@Override
		public int getRoleId() {
			return 4;
		}
	}, 
	报告人员 {
		@Override
		public int getRoleId() {
			return 5;
		}
	}, 
	教务处领导 {
		@Override
		public int getRoleId() {
			return 6;
		}
	}, 
	教务处主管教师 {
		@Override
		public int getRoleId() {
			// TODO Auto-generated method stub
			return 7;
		}
	}, 
	学院领导 {
		@Override
		public int getRoleId() {
			return 8;
		}
	}, 
	学院主管教师 {
		@Override
		public int getRoleId() {
			return 9;
		}
	}, 
	指导教师 {
		@Override
		public int getRoleId() {
			return 10;
		}
	}, 
	项目组长 {
		@Override
		public int getRoleId() {
			return 11;
		}
	}, 
	项目成员 {
		@Override
		public int getRoleId() {
			return 12;
		}
	};
	
	public abstract int getRoleId();
}
