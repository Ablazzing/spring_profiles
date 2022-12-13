package org.example.spring_profiles;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles(profiles = {"petr"})
public class MyTest {

}
