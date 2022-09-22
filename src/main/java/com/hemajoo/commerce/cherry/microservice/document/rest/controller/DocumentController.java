/*
 * (C) Copyright Resse Christophe 2021 - All Rights Reserved
 * -----------------------------------------------------------------------------------------------
 * All information contained herein is, and remains the property of
 * Resse Christophe. and its suppliers, if any. The intellectual and technical
 * concepts contained herein are proprietary to Resse C. and its
 * suppliers and may be covered by U.S. and Foreign Patents, patents
 * in process, and are protected by trade secret or copyright law.
 *
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained from
 * Resse Christophe (christophe.resse@gmail.com).
 * -----------------------------------------------------------------------------------------------
 */
package com.hemajoo.commerce.cherry.microservice.document.rest.controller;

import com.hemajoo.commerce.cherry.microservice.document.json.MicroserviceInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller providing endpoints to manage documents.
 * @author <a href="mailto:christophe.resse@gmail.com">Christophe Resse</a>
 * @version 1.0.0
 */
@Tag(name = "Document endpoints", description = "Document microservice endpoints to manage documents.")
@Validated
@RestController
@RequestMapping("/api/v1/ms/document")
public class DocumentController
{
    /**
     * Test endpoint.
     */
    @Operation(summary = "Microservice information", description = "Return information for the document microservice.")
    @GetMapping("/info")
    public ResponseEntity<MicroserviceInfo> info()
    {
        return ResponseEntity.ok(MicroserviceInfo.builder()
                .withTitle("Document Microservice")
                .withDescription("Microservice to manage documents.")
                .withVersion("0.1.0")
                .withAuthor("Hemajoo Ltd.")
                .withCopyright("Hemajoo (c) 2022 - All rights reserved")
                .build());
    }
}
