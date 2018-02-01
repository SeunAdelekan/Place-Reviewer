package com.example.placereviewer.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

/**
 * @author Iyanu Adelekan on 12/01/2018.
 */
@Controller
@RequestMapping("/say")
class HelloController {

    @GetMapping("/hello")
    fun hello(): String {
        return "hello"
    }
}