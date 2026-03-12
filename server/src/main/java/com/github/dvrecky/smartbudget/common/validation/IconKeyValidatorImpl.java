package com.github.dvrecky.smartbudget.common.validation;

import com.github.dvrecky.smartbudget.common.storage.config.IconConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IconKeyValidatorImpl implements IconKeyValidator {

    private final IconConfig iconConfig;

    public boolean isValidCategoryIconKey(String key) {
        return iconConfig.getCategories().contains(key);
    }

    public boolean isValidAccountIconKey(String key) {
        return iconConfig.getAccounts().contains(key);
    }

}
