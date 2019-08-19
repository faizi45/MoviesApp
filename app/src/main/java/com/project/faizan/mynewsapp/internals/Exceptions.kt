package com.project.faizan.mynewsapp.internals

import java.io.IOException

class ApiException(message: String, code: Int) : IOException(message)