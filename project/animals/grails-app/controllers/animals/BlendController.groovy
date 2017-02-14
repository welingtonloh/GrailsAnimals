package animals

import grails.converters.JSON

class BlendController {

    def blendService
    def moveService

    def index() {
        Move moveShark = moveService.save("Tubarão", "vive na água")
        Move moveMonkey = moveService.save("Macaco", "")
        
        blendService.index(moveShark, moveMonkey)
    }

    def first() {
    	render(template:"/blend/showMove", model: [blend: blendService.first()])
    }

    def nextMove() {
        def move = moveService.getByBlend(params.id, params.isLast.toBoolean())
        def nextBlend = blendService.nextMove(params.id, move)

        if (nextBlend) {
            render(template:"/blend/showMove", model: [blend: nextBlend])
        } else {
            render(template:"/blend/showAnimal", model: [move: move])
        }
    }

  	def success() {
    	render(template:"/blend/showSuccess", model: [message: "Acertei de novo"])
    }

    def restart() {
        render(template:"/blend/showInitial")
    }

    def add() {
        Move now = new Move()
        now.feature = ""
        now.animal = ""

        def last = moveService.get(params.id)
        def newBlend = blendService.add(last, now)
    	render(template: "/blend/addAnimal", model: [last: newBlend.last, now: newBlend.now])
    }

    def save() {
        def last = moveService.get(params.idLast) 
        def now = moveService.save(params.animal, "")
    	def newBlend = blendService.save(last, now)
        render(template: "/blend/addFeature", model: [blend: newBlend])
    }

    def update() {
    	blendService.update(params.id, params.feature)
        restart()
    }

    def delete() {
        def blend = blendService.get(params.id)
        blendService.delete(params.id)
        moveService.delete(blend.now.id)
        restart()
    }

    def deleteAll() {
        blendService.deleteAll()
        moveService.deleteAll()
        index()
        
        render(template:"/blend/showSuccess", model: [message: "Dados excluídos"])
    }
}