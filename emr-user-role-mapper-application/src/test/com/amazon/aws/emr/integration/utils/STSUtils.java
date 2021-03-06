package com.amazon.aws.emr.integration.utils;

import com.amazonaws.services.securitytoken.AWSSecurityTokenService;
import com.amazonaws.services.securitytoken.AWSSecurityTokenServiceClientBuilder;
import com.amazonaws.services.securitytoken.model.GetCallerIdentityRequest;
import com.amazonaws.services.securitytoken.model.GetCallerIdentityResult;

public class STSUtils {
  final static AWSSecurityTokenService sts =
      AWSSecurityTokenServiceClientBuilder.defaultClient();

  public static String getLoggedUserAccount() {
    GetCallerIdentityRequest callerIdentityRequest = new GetCallerIdentityRequest();
    GetCallerIdentityResult getCallerIdentityResult = sts.getCallerIdentity(callerIdentityRequest);
    return getCallerIdentityResult.getAccount();
  }
}
