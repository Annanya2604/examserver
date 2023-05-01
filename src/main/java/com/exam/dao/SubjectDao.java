package com.exam.dao;





public class SubjectDao {
	
	 private Long subjectId;//PK
		
		
		private String subjectName;
		
		
		
		private StandardDao standard;

		
		
		
		private SectionDao section;
//		@Column(name="section_id") //FK
//		private Long sectionId;
		
		public SubjectDao() {
			
		}

		public Long getSubjectId() {
			return subjectId;
		}

		public void setSubjectId(Long subjectId) {
			this.subjectId = subjectId;
		}

		public String getSubjectName() {
			return subjectName;
		}

		public void setSubjectName(String subjectName) {
			this.subjectName = subjectName;
		}

		public StandardDao getStandard() {
			return standard;
		}

		public void setStandard(StandardDao standard) {
			this.standard = standard;
		}

		public SectionDao getSection() {
			return section;
		}

		public void setSection(SectionDao section) {
			this.section = section;
		}

		
		
		
		
}
