/*
 * Copyright © 2018 Nedbank. All rights reserved.
 */

package com.daggerdemo.network.usecase;

import com.daggerdemo.entity.response.EmployeeResponseEntity;
import com.daggerdemo.network.domain.IApiCallRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

public class DemoRequestUseCase extends UseCase<String, EmployeeResponseEntity> {

    IApiCallRepository iApiCallRepository;
    @Inject
    DemoRequestUseCase(final UseCaseComposer useCaseComposer,
                       final IApiCallRepository iApiCallRepository)
    {
        super(useCaseComposer);
        this.iApiCallRepository = iApiCallRepository;
    }

    @Override
    protected Observable<EmployeeResponseEntity> createUseCaseObservable(String empId) {
        return this.iApiCallRepository.getEmployee(empId);
    }

}


