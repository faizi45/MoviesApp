package com.project.faizan.moviesgithub.internals

import java.io.IOException

class ApiException(message: String, code: Int) : IOException(message)