Pretty sure that none of the uses of opGet() in transferAssignField() can trigger
an error.  This is because they simply retrieve items previously pushed on the
stack prior to processing the method call.  Any errors that would occur due 
to these items should occur at time they are pushed onto the stack originally.
