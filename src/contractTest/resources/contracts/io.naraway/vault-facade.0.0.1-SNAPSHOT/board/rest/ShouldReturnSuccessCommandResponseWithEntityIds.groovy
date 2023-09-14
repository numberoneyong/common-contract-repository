import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("should return success command response with clip entity ids")
    name("should return success command response with clip entity ids")              // generate 되는 테스트의 메소드명이 된다. verifyingReturnAMember

    request{
        method POST()

        headers {
            contentType 'application/json'
        }

        urlPath("/open-clip-with-files/command") { // url 보다 urlPath가 선호된다. test가 host independent 해지기 때문.
            body(
                cabinetClient: $(
                    cabinetId: "1:1:1:1-1_kollectionId_dramaId_clientId",
                    client: $(
                        id: "clientId",
                        name: "clientName"
                    )
                ),
                "sourceFiles": [
                    $(
                        "name": "Hello.docx",
                        "size": 3000,
                        "creator": "Steve Jobs",
                        "createdOn": regex('^-?\\d{1,19}$'),
                        "modifiedOn": regex('^-?\\d{1,19}$')
                    )
                ]
            )
        }
    }

    response {
        status OK()
        body(
    """{"entityIds":["a2d8f53e-aea4-44ac-abcd-3f48a7f64b9e"],"requestFailed":false,"failureMessage":null}"""
        )

        headers {
            contentType('application/json')
        }
    }
}
