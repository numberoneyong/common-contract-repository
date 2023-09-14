import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("should return success command response")
    name("should return success command response")              // generate 되는 테스트의 메소드명이 된다. verifyingReturnAMember

    request{
        method POST()

        headers {
            contentType 'application/json'
        }


        urlPath("/feature/clip/open-cabinet/command") { // url 보다 urlPath가 선호된다. test가 host independent 해지기 때문.
            body(
    """{"cabinetPath": { "stageId": "1:1:1:1-1", "kollectionId": "kollectionId", "dramaId": "dramaId" }, "cabinetClient": { "cabinetId": "1:1:1:1-1_kollectionId_dramaId_clientId", "client": {"id": "clientId", "name":"clientName"}}}"""
            )
        }
    }
    response {
        status OK()
        body(
    """{ "entityIds": ["1:1:1:1-1_kollectionId_dramaId_clientId"], "requestFailed": false, "failureMessage": null }"""
        )

        headers {
            contentType('application/json')
        }
    }
}
