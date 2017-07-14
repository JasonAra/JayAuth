package com.exapot.controller;

import com.exapot.model.Token;
import org.springframework.stereotype.Controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ehsaniara
 * From https://www.exapot.com
 */
@Controller
public class TokenController {

    public static long expTimeSec = 30 * 60 * 1000;

    public static Map<Long, Token> tokenMap = Collections.synchronizedMap(new HashMap<Long, Token>());


}
