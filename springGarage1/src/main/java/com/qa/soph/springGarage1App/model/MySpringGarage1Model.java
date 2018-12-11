package com.qa.soph.springGarage1App.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name = "Vehicle")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"creationDate", "lastModified"}, allowGetters = true)



public class MySpringGarage1Model implements Serializable{
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@NotBlank
		private String vehicleType;
		
		
		private Integer age;
		
		@Column(nullable = false, updatable = false)
		//@Temporal(TemporalType.TIMESTAMP)
		@CreationTimestamp
		@CreatedDate
		private Date creationDate;
		
		@Column(nullable = false)
		//@Temporal(TemporalType.TIMESTAMP)
		@UpdateTimestamp
		@LastModifiedDate
		private Date lastModified;
		
		
		public String getVehicleType() {
			return vehicleType;
		}
		
		public void setVehicleType(String vehicleType) {
			this.vehicleType = vehicleType;
		}
		
		public Integer getAge() {
			return age;
		}
		
		public void setAge(Integer age) {
			this.age = age;
		}
		
		public Date getCreationDate() {
			return creationDate;
		}
		
		public void setCreationDate(Date creationDate) {
			this.creationDate = creationDate;
		}
		
		public Date getLastModified() {
			return lastModified;
		}
		public void setLastModified(Date lastModified) {
			this.lastModified = lastModified;
			
		}
}
