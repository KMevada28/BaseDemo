

package com.mvp_base.network.usecase;

import com.mvp_base.entity.response.EmployeeResponseEntity;
import com.mvp_base.network.domain.IApiCallRepository;

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


