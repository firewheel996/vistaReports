package org.ohiocdc



import org.junit.*
import grails.test.mixin.*

@TestFor(ReportLayoutController)
@Mock(ReportLayout)
class ReportLayoutControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/reportLayout/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.reportLayoutInstanceList.size() == 0
        assert model.reportLayoutInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.reportLayoutInstance != null
    }

    void testSave() {
        controller.save()

        assert model.reportLayoutInstance != null
        assert view == '/reportLayout/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/reportLayout/show/1'
        assert controller.flash.message != null
        assert ReportLayout.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/reportLayout/list'

        populateValidParams(params)
        def reportLayout = new ReportLayout(params)

        assert reportLayout.save() != null

        params.id = reportLayout.id

        def model = controller.show()

        assert model.reportLayoutInstance == reportLayout
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/reportLayout/list'

        populateValidParams(params)
        def reportLayout = new ReportLayout(params)

        assert reportLayout.save() != null

        params.id = reportLayout.id

        def model = controller.edit()

        assert model.reportLayoutInstance == reportLayout
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/reportLayout/list'

        response.reset()

        populateValidParams(params)
        def reportLayout = new ReportLayout(params)

        assert reportLayout.save() != null

        // test invalid parameters in update
        params.id = reportLayout.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/reportLayout/edit"
        assert model.reportLayoutInstance != null

        reportLayout.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/reportLayout/show/$reportLayout.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        reportLayout.clearErrors()

        populateValidParams(params)
        params.id = reportLayout.id
        params.version = -1
        controller.update()

        assert view == "/reportLayout/edit"
        assert model.reportLayoutInstance != null
        assert model.reportLayoutInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/reportLayout/list'

        response.reset()

        populateValidParams(params)
        def reportLayout = new ReportLayout(params)

        assert reportLayout.save() != null
        assert ReportLayout.count() == 1

        params.id = reportLayout.id

        controller.delete()

        assert ReportLayout.count() == 0
        assert ReportLayout.get(reportLayout.id) == null
        assert response.redirectedUrl == '/reportLayout/list'
    }
}
