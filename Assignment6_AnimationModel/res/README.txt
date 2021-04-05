The Shape interface specifies all the functionalities a shape has. 
All the concrete classes that implement the Shape interface have a name, current position of the center/corner, the current color and appear time along with disappear time. 
Shapes supported for now includes:
- Oval, Circle: Position is specified by the center coordinates and shape is specified by the radii
- Triangle: Position is specified by the bottom left vertex coordinates and shape is specified by the bottom left angle and two neighboring sides, with the bottom one being side1
- Quadrilaterals: Position is specified by the bottom left vertex coordinates and shape is generally specified by bottom left angle and two neighboring sides, with the bottom one being side1
	- Parallelogram: Angle and two sides
	- Rhombus: Angle and one side
	- Rectangle: two sides
	- Square: one side

Animation Interface represents a specific transformation of a shape. 
ChangeColor class, Display class, Move class, Scale class and Vanish Class implements the functionalities specified in the Animation interface, recording the time interval the transformation being made and also properties of the corresponding shape both before and after the transformation. 

The AnimationModel interface specifies all contracts an animation model implementation should adhere to. 
It supports all functionalities of an animation model including adding and removing various kinds of 2D shapes, as well as creating various kinds of animations to shapes, such as moving, changing color and scaling. 
AnimationModelImpl implements all the functionalities of AnimationModel interface. 
The model bonds each shape with all its valid animations by storing the shape and the animation list as a key-value pair in a hashmap.  
Before the new animation being made to a shape, the model will get the existing animation records of that shape first, then loop over the records to check for time conflict, and finally insert the new animation into the right place in the order of start time if the new animation step is consistent with other records. 

