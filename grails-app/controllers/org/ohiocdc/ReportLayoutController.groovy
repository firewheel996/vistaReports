package org.ohiocdc

import org.springframework.dao.DataIntegrityViolationException

class ReportLayoutController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [reportLayoutInstanceList: ReportLayout.list(params), reportLayoutInstanceTotal: ReportLayout.count()]
    }

    def create() {
        [reportLayoutInstance: new ReportLayout(params)]
    }

    def save() {
        def reportLayoutInstance = new ReportLayout(params)
        if (!reportLayoutInstance.save(flush: true)) {
            render(view: "create", model: [reportLayoutInstance: reportLayoutInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'reportLayout.label', default: 'ReportLayout'), reportLayoutInstance.id])
        redirect(action: "show", id: reportLayoutInstance.id)
    }

    def show(Long id) {
        def reportLayoutInstance = ReportLayout.get(id)
        if (!reportLayoutInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'reportLayout.label', default: 'ReportLayout'), id])
            redirect(action: "list")
            return
        }

        [reportLayoutInstance: reportLayoutInstance]
    }

    def edit(Long id) {
        def reportLayoutInstance = ReportLayout.get(id)
        if (!reportLayoutInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'reportLayout.label', default: 'ReportLayout'), id])
            redirect(action: "list")
            return
        }

        [reportLayoutInstance: reportLayoutInstance]
    }

    def update(Long id, Long version) {
        def reportLayoutInstance = ReportLayout.get(id)
        if (!reportLayoutInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'reportLayout.label', default: 'ReportLayout'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (reportLayoutInstance.version > version) {
                reportLayoutInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'reportLayout.label', default: 'ReportLayout')] as Object[],
                          "Another user has updated this ReportLayout while you were editing")
                render(view: "edit", model: [reportLayoutInstance: reportLayoutInstance])
                return
            }
        }

        reportLayoutInstance.properties = params

        if (!reportLayoutInstance.save(flush: true)) {
            render(view: "edit", model: [reportLayoutInstance: reportLayoutInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'reportLayout.label', default: 'ReportLayout'), reportLayoutInstance.id])
        redirect(action: "show", id: reportLayoutInstance.id)
    }

    def delete(Long id) {
        def reportLayoutInstance = ReportLayout.get(id)
        if (!reportLayoutInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'reportLayout.label', default: 'ReportLayout'), id])
            redirect(action: "list")
            return
        }

        try {
            reportLayoutInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'reportLayout.label', default: 'ReportLayout'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'reportLayout.label', default: 'ReportLayout'), id])
            redirect(action: "show", id: id)
        }
    }
}
