Tests two things related to parameterized types:

(1) that we don't get confused by the same parameterized type appearing in
different compilation units.  This used to be a problem caused by a race
condition.  We could have one representative result folder for the
parameterized type per compilation unit, rather than just one folder globally.

(2) That we no longer point to any IRNode for the actual type parameter 
result folders.  If we did, we could have misleading diffs caused by the
non deterministic way we used to pick representive ParameterizedType nodes.
