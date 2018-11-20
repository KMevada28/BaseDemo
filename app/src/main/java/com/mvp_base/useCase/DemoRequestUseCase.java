

package com.mvp_base.useCase;

import com.mvp_base.dataModel.EmployeeResponseDataModel;
import com.mvp_base.mapper.entityToDataModel.EmployeeResponseEntityToDataModelMapper;
import com.mvp_base.network.domain.IApiCallRepository;
import com.mvp_base.network.usecase.UseCase;
import com.mvp_base.network.usecase.UseCaseComposer;

import javax.inject.Inject;

import io.reactivex.Observable;

public class DemoRequestUseCase extends UseCase<String, EmployeeResponseDataModel> {

    private IApiCallRepository iApiCallRepository;
    private EmployeeResponseEntityToDataModelMapper employeeResponseEntityToDataModelMapper;

    @Inject
    public DemoRequestUseCase(UseCaseComposer useCaseComposer,
                              IApiCallRepository iApiCallRepository,
                              EmployeeResponseEntityToDataModelMapper employeeResponseEntityToDataModelMapper) {
        super(useCaseComposer);
        this.iApiCallRepository = iApiCallRepository;
        this.employeeResponseEntityToDataModelMapper = employeeResponseEntityToDataModelMapper;
    }

    @Override
    protected Observable<EmployeeResponseDataModel> createUseCaseObservable(String empId) {
        return this.iApiCallRepository.getEmployee(empId).map(employeeResponseEntity -> employeeResponseEntityToDataModelMapper.mapEmployeeResponseDataModel(employeeResponseEntity));
    }

}


