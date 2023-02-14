package com.samples.response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PurchaseHistoryResponse {
	private int  petId;
	private String petName;
	private int quentitySolid;
	private LocalDate solidDate;
}
