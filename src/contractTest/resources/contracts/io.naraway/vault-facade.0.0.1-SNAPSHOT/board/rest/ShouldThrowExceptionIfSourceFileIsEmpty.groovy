import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("should throw exception if source files are empty")
    name("should throw exception if source files are empty")

    request{
        method POST()

        headers {
            contentType 'application/json'
        }

        urlPath("/open-clip-with-files/command") {
            body(
                cabinetClient: $(
                    cabinetId: "1:1:1:1-1_kollectionId_dramaId_clientId",
                    client: $(
                        id: "clientId",
                        name: "clientName"
                    )
                ),
                "sourceFiles": []
            )
        }
    }

    response {
        status OK()
        body(
                "requestFailed": true,
                "failureMessage": $(
                    "exceptionName": "IllegalArgumentException",
                    "exceptionMessage": "'sourceFiles' is required",
                    "exceptionCode": null
                )
        )

        headers {
            contentType('application/json')
        }
    }
}

