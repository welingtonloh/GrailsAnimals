package animals

import grails.transaction.Transactional

@Transactional
class MoveService {

	def save(animal, feature) {
		Move move = new Move()
        move.animal = animal
        move.feature = feature

        move.validate()
    	if (!move.hasErrors()) {
        	move.save(flush:true)
    	} else {
    		println move.errors.allErrors
    	}
	}

	def getByBlend(id, isLast) {
    	def blend = Blend.get(id)
    	def move = new Move()
    	
    	if (blend) {
    		if (isLast) { 
    			move = blend.last
    		} else {
    			move = blend.now
    		}
    	}

    	return move
    }

    def get(id) {
    	def move = Move.get(id)
    	return move
    }

    def deleteAll() {
    	Move.executeUpdate('delete from Move')
    }

    def delete(id) {
    	def move = Move.get(id)
    	move.delete(flush:true)
    }
}
