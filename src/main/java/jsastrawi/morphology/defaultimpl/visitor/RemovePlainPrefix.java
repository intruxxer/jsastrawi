package jsastrawi.morphology.defaultimpl.visitor;

import jsastrawi.morphology.defaultimpl.Context;
import jsastrawi.morphology.defaultimpl.Removal;
import jsastrawi.morphology.defaultimpl.RemovalImpl;

class RemovePlainPrefix implements ContextVisitor {

    @Override
    public void visit(Context context) {
        String result = remove(context.getCurrentWord());
        
        if (!result.equals(context.getCurrentWord())) {
            String removedPart = context.getCurrentWord().replaceFirst(result, "");
            
            Removal r = new RemovalImpl(this, context.getCurrentWord(), result, removedPart, "DP");
            context.addRemoval(r);
            context.setCurrentWord(result);
        }
    }
    
    public String remove(String word) {
        return word.replaceAll("^(di|ke|se)", "");
    }
    
}