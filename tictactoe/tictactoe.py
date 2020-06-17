"""
Tic Tac Toe Player
"""

import math
import copy


X = "X"
O = "O"
EMPTY = None

class InvalidInputError(Exception):
    pass

def initial_state():
    """
    Returns starting state of the board.
    """
    return [[EMPTY, EMPTY, EMPTY],
            [EMPTY, EMPTY, EMPTY],
            [EMPTY, EMPTY, EMPTY]]

def player(board):
    numx = 0
    numo = 0
    for lst in board:
        for ele in lst:
            if ele is X:
                numx += 1
            if ele is O:
                numo += 1
    if numx == numo:
        return X
    elif numx > numo:
        return O


def actions(board):
    possibleactions = set()
    for i in range(len(board)):
        for j in range(len(board[i])):
            if board[i][j] is EMPTY:
                possibleactions.add((i,j))
    return possibleactions


def result(board, action):
    possibleresult = copy.deepcopy(board)
    (i,j) = action
    if possibleresult[i][j] is not EMPTY:
        raise InvalidInputError
    else:
        possibleresult[i][j] = player(board)
    return possibleresult


def winner(board):
    """horizontal check"""
    for lst in board:
        l = 0
        m = 0
        for ele in lst:
            if ele == X:
                l += 1
            elif ele == O:
                m += 1
        if l == 3:
            return X
        if m == 3:
            return O
    """vertical check"""
    for j in range(len(board)):
        l = 0
        m = 0
        for i in range(len(board)):
            if board[i][j] == X:
                l += 1
            elif board[i][j] == O:
                m += 1
        if l == 3:
            return X
        if m == 3:                 
            return O
    """diagonal check"""
    if board[1][1] == X:
        if board[0][0] == X and board[2][2] == X:
            return X
        if board[0][2] == X and board[2][0] == X:
            return X
    elif board[1][1] == O:
        if board[0][0] == O and board[2][2] == O:
            return O
        if board[0][2] == O and board[2][0] == O:
            return O
    return None


def terminal(board):
    if winner(board) is not None:
        return True
    for lst in board:
        for ele in lst:
            if ele is EMPTY:
                return False
    return True

def utility(board):
    if winner(board) == X:
        return 1
    elif winner(board) == O:
        return -1
    else:
        return 0

def minimax(board):
    bestMove = None
    curr_player = player(board) 
    bestval = -math.inf
    if curr_player == O:
        bestval = math.inf
    if terminal(board):
        return bestMove
    for i in range(len(board)):
        for j in range(len(board)):
            if board[i][j] is EMPTY:
                currval = bestmove(result(board,(i,j)))
                if curr_player == X and currval > bestval:
                    bestval = currval
                    bestMove = (i,j)
                elif curr_player == O and currval < bestval:
                    bestval = currval
                    bestMove = (i,j)
    return bestMove
          
def bestmove(board):
    if player(board) == X:
        return maxvalue(board)
    else:
       return minvalue(board)

def maxvalue(board):
    if terminal(board):
        return utility(board)
    value = -math.inf
    for action in actions(board):
        value = max(value,minvalue(result(board,action)))
    return value

def minvalue(board):
    if terminal(board):
        return utility(board)
    value = math.inf
    for action in actions(board):
        value = min(value,maxvalue(result(board,action)))
    return value

