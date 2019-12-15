package com.json_java;

import lombok.*;

@AllArgsConstructor
@ToString
@Setter
@Getter
@Builder
public class LombokUse {
    private @NonNull String name;
    private String job;

}


//We can use @Data which is combination of @AllArgsConstructor @Getter @Setter @EqualsAndHashCode @ToString
//We can use @NonNull if data is No