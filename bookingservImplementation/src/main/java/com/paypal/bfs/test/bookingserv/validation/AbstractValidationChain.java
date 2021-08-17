package com.paypal.bfs.test.bookingserv.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractValidationChain<T > implements IValidationChain<T> {

	protected List<String> listOfValidations;

	@Autowired
	ApplicationContext applicationContext;

	@Override
	public ValidatorResponse performValidation(T request) {

		if (CollectionUtils.isEmpty(listOfValidations))
			return new ValidatorResponse().setStatus(ValidatorResponse.ValidationStatus.SUCCESS);

		ValidatorResponse commonValidatorResponse = null;
		List<ErrorObject> errors = null;
		for (String validationId : listOfValidations) {
			ValidatorResponse validatorResponse = applicationContext.getBean(validationId, IValidator.class)
					.validate(request);
			if (validatorResponse.getStatus().equals(ValidatorResponse.ValidationStatus.FAILURE)){
				if(commonValidatorResponse==null){
					commonValidatorResponse = new ValidatorResponse().setStatus(ValidatorResponse.ValidationStatus.FAILURE).setFailureMessage(validatorResponse.getFailureMessage());
				}
				if (!CollectionUtils.isEmpty(validatorResponse.getErrors())) {
					if (errors == null)
						errors = new ArrayList<>();
					errors.addAll(validatorResponse.getErrors());
				}
			}
				
		}
		if(commonValidatorResponse!=null){
			return new ValidatorResponse().setStatus(ValidatorResponse.ValidationStatus.FAILURE)
					.setFailureMessage(commonValidatorResponse.getFailureMessage()).setErrors(errors);
		}
		return new ValidatorResponse().setStatus(ValidatorResponse.ValidationStatus.SUCCESS);
	}
}
