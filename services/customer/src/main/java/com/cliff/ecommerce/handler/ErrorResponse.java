package com.cliff.ecommerce.handler;

import java.util.HashMap;
import java.util.Map;

public record ErrorResponse(Map<String, String> errors) {

}
