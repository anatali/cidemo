
%==============================================
% CONTEXT HANDLING UTILTY
%==============================================
getTheActors(ACTORS) :-
	findall( qactor( A, CTX, CLASS ), qactor( A, CTX, CLASS ), ACTORS).

showSystemConfiguration :-
	stdout <- println("-----------------SysRules----------------------"),
	stdout <- println('ACTORS   IN THE SYSTEM:'),
	getTheActors(ACTORS),
	showListOfElements(ACTORS),
	stdout <- println("-----------------SysRules----------------------").
 
showListOfElements([]).
showListOfElements([C|R]):-
	stdout <- println( C ),
	showListOfElements(R).
