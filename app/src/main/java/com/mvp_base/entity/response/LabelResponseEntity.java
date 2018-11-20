package com.mvp_base.entity.response;

import com.squareup.moshi.Json;

import java.util.List;

public class LabelResponseEntity {

    @Json(name = "labels")
    private List<LabelEntity> labels = null;
    @Json(name = "ErrorCode")
    private String errorCode;
    @Json(name = "ErrorDescription")
    private String errorDescription;

    public List<LabelEntity> getLabels() {
        return labels;
    }

    public void setLabels(List<LabelEntity> labels) {
        this.labels = labels;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }
}