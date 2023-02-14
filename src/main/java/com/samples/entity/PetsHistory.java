package com.samples.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PetsHistory {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int petHisId;
	private int petId;
	private int quentitySolid;
	private LocalDate solidDate;
}
