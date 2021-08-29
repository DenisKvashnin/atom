package ru.atom.hachaton.advisors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import feign.FeignException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.atom.hachaton.utils.ApiError;

class ControllerAdvisorTest {

    @Test
    void testIllegalArgumentExceptionHandler() {
        ControllerAdvisor controllerAdvisor = new ControllerAdvisor();
        ResponseEntity<ApiError> actualIllegalArgumentExceptionHandlerResult = controllerAdvisor
                .illegalArgumentExceptionHandler(new IllegalArgumentException("foo"));
        assertTrue(actualIllegalArgumentExceptionHandlerResult.getHeaders().isEmpty());
        assertTrue(actualIllegalArgumentExceptionHandlerResult.hasBody());
        assertEquals(HttpStatus.BAD_REQUEST, actualIllegalArgumentExceptionHandlerResult.getStatusCode());
        ApiError body = actualIllegalArgumentExceptionHandlerResult.getBody();
        assert body != null;
        assertEquals("foo", body.getMessage());
        assertTrue(body.getErrors().isEmpty());
        assertEquals(400, body.getCode());
    }

    @Test
    void testIllegalArgumentExceptionHandler2() {
        ControllerAdvisor controllerAdvisor = new ControllerAdvisor();

        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        illegalArgumentException.addSuppressed(new Throwable());
        ResponseEntity<ApiError> actualIllegalArgumentExceptionHandlerResult = controllerAdvisor
                .illegalArgumentExceptionHandler(illegalArgumentException);
        assertTrue(actualIllegalArgumentExceptionHandlerResult.getHeaders().isEmpty());
        assertTrue(actualIllegalArgumentExceptionHandlerResult.hasBody());
        assertEquals(HttpStatus.BAD_REQUEST, actualIllegalArgumentExceptionHandlerResult.getStatusCode());
        ApiError body = actualIllegalArgumentExceptionHandlerResult.getBody();
        assert body != null;
        assertNull(body.getMessage());
        assertTrue(body.getErrors().isEmpty());
        assertEquals(400, body.getCode());
    }

    @Test
    void testNullPointExceptionHandler() {
        ResponseEntity<ApiError> actualNullPointExceptionHandlerResult = (new ControllerAdvisor())
                .nullPointExceptionHandler(new NullPointerException());
        assertTrue(actualNullPointExceptionHandlerResult.getHeaders().isEmpty());
        assertTrue(actualNullPointExceptionHandlerResult.hasBody());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, actualNullPointExceptionHandlerResult.getStatusCode());
        ApiError body = actualNullPointExceptionHandlerResult.getBody();
        assert body != null;
        assertEquals("Ошибка на стороне сервера.", body.getMessage());
        assertTrue(body.getErrors().isEmpty());
        assertEquals(500, body.getCode());
    }

    @Test
    void testFeignException() {
        ControllerAdvisor controllerAdvisor = new ControllerAdvisor();
        FeignException feignException = mock(FeignException.class);
        when(feignException.status()).thenReturn(1);
        ResponseEntity<ApiError> actualFeignExceptionResult = controllerAdvisor.feignException(feignException);
        assertTrue(actualFeignExceptionResult.getHeaders().isEmpty());
        assertTrue(actualFeignExceptionResult.hasBody());
        assertEquals(HttpStatus.OK, actualFeignExceptionResult.getStatusCode());
        ApiError body = actualFeignExceptionResult.getBody();
        assert body != null;
        assertEquals("Ошибка на стороне сервера.", body.getMessage());
        assertTrue(body.getErrors().isEmpty());
        assertEquals(500, body.getCode());
        verify(feignException).status();
    }

    @Test
    void testFeignException2() {
        ControllerAdvisor controllerAdvisor = new ControllerAdvisor();
        FeignException feignException = mock(FeignException.class);
        when(feignException.status()).thenReturn(401);
        ResponseEntity<ApiError> actualFeignExceptionResult = controllerAdvisor.feignException(feignException);
        assertNull(actualFeignExceptionResult.getBody());
        assertEquals("<401 UNAUTHORIZED Unauthorized,[]>", actualFeignExceptionResult.toString());
        assertEquals(HttpStatus.UNAUTHORIZED, actualFeignExceptionResult.getStatusCode());
        assertTrue(actualFeignExceptionResult.getHeaders().isEmpty());
        verify(feignException).status();
    }
}

