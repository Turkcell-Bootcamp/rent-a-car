package com.example.rentacar.adapters;

import com.example.rentacar.business.abstracts.PosService;
import com.example.rentacar.common.constants.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

/*
 *   Created by emrah.yilm4z on 4/10/2023
 */
@AllArgsConstructor
@Service
public class FakePosServiceAdapter implements PosService {

	@Override
	public void pay() {

		boolean isPaymentSuccesful = new Random().nextBoolean();
		if (!isPaymentSuccesful)
			throw new RuntimeException(Messages.Payment.Failed);
	}
}
