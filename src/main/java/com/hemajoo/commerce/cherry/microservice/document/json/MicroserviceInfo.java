/*
 * (C) Copyright Hemajoo Systems Inc.  2022 - All Rights Reserved
 * -----------------------------------------------------------------------------------------------
 * All information contained herein is, and remains the property of
 * Hemajoo Inc. and its suppliers, if any. The intellectual and technical
 * concepts contained herein are proprietary to Hemajoo Inc. and its
 * suppliers and may be covered by U.S. and Foreign Patents, patents
 * in process, and are protected by trade secret or copyright law.
 *
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained from
 * Hemajoo Systems Inc.
 * -----------------------------------------------------------------------------------------------
 */
package com.hemajoo.commerce.cherry.microservice.document.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class MicroserviceInfo
{
    /**
     * Title.
     */
    @JsonProperty("title")
    private String title;

    /**
     * Description.
     */
    @JsonProperty("description")
    private String description;

    /**
     * Version.
     */
    @JsonProperty("version")
    private String version;

    /**
     * Author.
     */
    @JsonProperty("author")
    private String author;

    /**
     * Copyright.
     */
    @JsonProperty("copyright")
    private String copyright;

    @Builder(setterPrefix = "with")
    public MicroserviceInfo(final @NonNull String title, final @NonNull String description, final @NonNull String version, final @NonNull String author, final @NonNull String copyright)
    {
        this.title = title;
        this.description = description;
        this.version = version;
        this.author = author;
        this.copyright = copyright;
    }
}
