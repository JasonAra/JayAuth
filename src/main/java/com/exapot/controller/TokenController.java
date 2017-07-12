package com.exapot.controller;

import com.exapot.model.Token;
import org.springframework.stereotype.Controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jason Ara (Jay.Ara) on 7/11/17.
 * From https://www.exapot.com
 */
@Controller
public class TokenController {

    public static Map<Long, Token> tokenMap = Collections.synchronizedMap(new HashMap<Long, Token>());


}
