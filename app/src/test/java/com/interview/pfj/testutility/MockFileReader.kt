package com.interview.pfj.testutility

import okio.buffer
import okio.source
import java.nio.charset.StandardCharsets

class MockFileReader(private val path: String) {
    fun getFakeJsonResponse(): String {
        val inputStream = javaClass.classLoader?.getResourceAsStream(path)
        val source = inputStream?.let { inputStream.source().buffer() }
        val content = source?.readString(StandardCharsets.UTF_8).toString()
        source?.close()
        return content
    }
}