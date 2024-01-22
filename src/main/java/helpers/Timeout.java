package helpers;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.Duration;

import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;
@Getter
@RequiredArgsConstructor
public enum Timeout {

    API_TIMEOUT(240, ofSeconds(240)),
    CACHE_VISIT_TIMEOUT(90, ofSeconds(90)),
    LONG_TIMEOUT(10, ofSeconds(13)),
    SHORT_TIMEOUT(5, ofSeconds(5)),
    POLL_INTERVAL(2, ofSeconds(2)),

    MILLI_SECONDS_TIMEOUT(500, ofMillis(500));

    private final int timeout;
    private final Duration duration;
}
