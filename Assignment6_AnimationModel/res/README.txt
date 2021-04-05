The Shape interface specifies all the functionalities a shape has. 
All the concrete classes that implement the Shape interface have a name, original position of the center/corner, the original color and appear time along with disappear time. 

Animation Interface represents a specific transformation of a shape. 
ChangeColor class, Display class, Move class, Scale class and Vanish Class implements the functionalities specified in the Animation interface, recording the time interval the transformation being made and also properties of the corresponding shape both before and after the transformation. 

The AnimationModel interface specifies all contracts an animation model implementation should adhere to. 
It supports all functionalities of an animation model including adding and removing various kinds of 2D shapes, as well as creating various kinds of animations to shapes, such as moving, changing color and scaling. 
AnimationModelImpl implements all the functionalities of AnimationModel interface. 
The model bonds each shape with all its valid animations by storing the shape and the animation list as a key-value pair in a hashmap.  
Before the new animation being made to a shape, the model will get the existing animation records of that shape first, then loop over the records to check for time conflict, and finally insert the new animation into the right place in the order of start time if the new animation step is consistent with other records. 

