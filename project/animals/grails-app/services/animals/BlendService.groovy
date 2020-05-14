package animals

import grails.transaction.Transactional

@Transactional
class BlendService {

    def first() {
    	Blend blend = Blend.first()
    	return blend
    }

    def index(moveShark, moveMonkey) {
    	if(Blend.count() == 0) {
            Blend blend = new Blend()
            blend.last = moveMonkey
            blend.now = moveShark

            blend.validate()
	    	if (!blend.hasErrors()) {
            	blend.save(flush:true)
        	} else {
        		println now.errors.allErrors
        	}
        }
    }

    def nextMove(id, move) {
    	def blend = Blend.get(id)
    	def nextBlend = null
    
    	if(blend && move) {
    		nextBlend = Blend.findByLastAndIdGreaterThan(move, blend.id)	
    	}
	
    	return nextBlend
    }

    def add(last, now) {
    	Blend newBlend = new Blend()

    	newBlend.last = last
    	newBlend.now = now

    	return newBlend
    }

    def save(last, now) {
    	try{
	    	Blend newBlend = add(last, now)

    		newBlend.validate()
	    	if (!newBlend.hasErrors()) {
	    		newBlend.save(flush:true)
			} else {
	            println newBlend.errors.allErrors
	        }
			
        	return newBlend;
        } catch(Exception exception){
        	throw new Exception("Preencha todos os campos.")
        }
    }

    def update(id, feature) {
    	Blend blend = Blend.get(id)
    	blend.now.feature = feature

    	blend.validate()
    	if (!blend.hasErrors()) {
    		blend.save(flush:true)
		} else {
            println blend.errors.allErrors
        }
    }

    def delete(id) {
    	Blend blend = Blend.get(id)
    	blend.delete(flush:true)
    }

    def deleteAll() {
    	Blend.executeUpdate('delete from Blend')        
    }

    def get(id) {
    	return Blend.get(id)
    }
}
