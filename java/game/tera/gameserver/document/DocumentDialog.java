package tera.gameserver.document;

import java.io.File;
import java.lang.reflect.InvocationTargetException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import rlib.data.AbstractDocument;
import rlib.util.VarTable;
import rlib.util.array.Array;
import rlib.util.array.Arrays;
import rlib.util.table.IntKey;
import rlib.util.table.Table;
import rlib.util.table.Tables;
import tera.gameserver.model.npc.interaction.DialogData;
import tera.gameserver.model.npc.interaction.IconType;
import tera.gameserver.model.npc.interaction.Link;
import tera.gameserver.model.npc.interaction.LinkType;
import tera.gameserver.model.npc.interaction.links.NpcLink;
import tera.gameserver.model.npc.interaction.replyes.Reply;

/**
 * ÐŸÐ°Ñ€Ñ�ÐµÑ€ Ñ�Ñ�Ñ‹Ð»Ð¾Ðº Ð½Ð¿Ñ� Ð´Ð¸Ð°Ð»Ð¾Ð³Ð¾Ð².
 *
 * @author Ronn Mod Evestu
 */
public final class DocumentDialog extends AbstractDocument<Table<IntKey, Table<IntKey, DialogData>>>
{
	/**
	 * ÐŸÐ°Ñ€Ñ� Ñ�Ñ�Ñ‹Ð»ÐºÐ¸ Ð² Ð´Ð¸Ð°Ð»Ð¾Ð³Ðµ.
	 *
	 * @param node Ð´Ð°Ð½Ð½Ñ‹Ðµ Ñ� Ñ…Ð¼Ð».
	 * @return Ð½Ð¾Ð²Ð°Ñ� Ñ�Ñ�Ñ‹Ð»ÐºÐ°.
	 */
	public static Link parseLink(Node node)
	{
		// Ð¿Ð¾Ð»ÑƒÑ‡Ð°ÐµÐ¼ Ð°Ñ‚Ñ‚Ñ€Ð¸Ð±ÑƒÑ‚Ñ‹ Ñ�Ñ�Ñ‹Ð»ÐºÐ¸
		VarTable vars = VarTable.newInstance(node);

		// Ð¿Ð¾Ð»ÑƒÑ‡Ð°ÐµÐ¼ Ð½Ð°Ð·Ð²Ð°Ð½Ð¸Ðµ Ñ�Ñ�Ñ‹Ð»ÐºÐ¸
		String name = vars.getString("name");

		// Ð¿Ð¾Ð»ÑƒÑ‡Ð°ÐµÐ¼ Ð¸ÐºÐ¾Ð½ÐºÑƒ
		IconType icon = vars.getEnum("icon", IconType.class, IconType.NONE);

		Reply reply = null;

		//Ð¿Ð°Ñ€Ñ�Ð¸Ð¼ Ð¾Ñ‚Ð²ÐµÑ‚ Ð½Ð° Ñ�Ñ�Ñ‹Ð»ÐºÑƒ
		for(Node child = node.getFirstChild(); child != null; child = child.getNextSibling())
		{
			//Ð½Ð°Ñ…Ð¾Ð´Ð¸Ð¼ Ð¾Ñ‚Ð²ÐµÑ‚
			if("reply".equals(child.getNodeName()))
			{
				//Ð¿Ð¾Ð»ÑƒÑ‡Ð°ÐµÐ¼ Ð½Ð°Ð·Ð²Ð°Ð½Ð¸Ðµ Ð¾Ñ‚Ð²ÐµÑ‚Ð°
				String replyName = child.getAttributes().getNamedItem("name").getNodeValue();

				if(replyName == null)
					continue;

				//Ñ�Ð¾Ð·Ð´Ð°ÐµÐ¼ Ñ�ÐºÐ·ÐµÐ¼Ð¿Ð»Ñ�Ñ€ Ð¾Ñ‚Ð²ÐµÑ‚Ð°
				try
				{
					reply = (Reply) Class.forName("tera.gameserver.model.npc.interaction.replyes." + replyName).getConstructor(Node.class).newInstance(child);
				}
				catch(ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
				{
					log.warning(DocumentDialog.class, e);
				}
			}
		}

		//Ð’Ð¾Ð·Ð²Ñ€Ð°Ñ‰Ð°ÐµÐ¼ Ð³Ð¾Ñ‚Ð¾Ð²ÑƒÑŽ Ñ�Ñ�Ñ‹Ð»ÐºÑƒ Ñ� Ð¾Ñ‚Ð²ÐµÑ‚Ð¾Ð¼
		return new NpcLink(name, LinkType.DIALOG, icon, reply);
	}

	/**
	 * @param file Ð¾Ñ‚Ð¿Ñ€Ð°Ñ�Ð¸Ð²Ð°ÐµÐ¼Ñ‹Ð¹ Ñ„Ð°Ð¸Ð».
	 */
	public DocumentDialog(File file)
	{
		super(file);
	}

	@Override
	protected Table<IntKey, Table<IntKey, DialogData>> create()
	{
		return Tables.newIntegerTable();
	}

	@Override
	protected void parse(Document doc)
	{
		for(Node lst = doc.getFirstChild(); lst != null; lst = lst.getNextSibling())
			if("list".equals(lst.getNodeName()))
				for(Node npc = lst.getFirstChild(); npc != null; npc = npc.getNextSibling())
					if("npc".equals(npc.getNodeName()))
					{
						DialogData dialog = parseNpc(npc);

						Table<IntKey, DialogData> table = result.get(dialog.getNpcId());

						if(table == null)
						{
							table = Tables.newIntegerTable();

							result.put(dialog.getNpcId(), table);
						}

						table.put(dialog.getType(), dialog);
					}
	}

	/**
	 * ÐŸÐ°Ñ€Ñ�Ð¸Ð¼ Ð´Ð¸Ð°Ð»Ð¾Ð³ Ð½Ð¿Ñ� Ñ� Ñ…Ð¼Ð».
	 *
	 * @param node Ð´Ð°Ð½Ð½Ñ‹Ðµ Ñ� Ñ�Ñ…Ð¼Ð».
	 * @return Ð½Ð¾Ð²Ñ‹Ð¹ Ð´Ð¸Ð°Ð»Ð¾Ð³.
	 */
	private DialogData parseNpc(Node node)
	{
		// Ð¿Ð¾ÑƒÑ‡Ð°ÐµÐ¼ Ð°Ñ‚Ñ€Ð¸Ð±ÑƒÑ‚Ñ‹ Ð´Ð¸Ð°Ð»Ð¾Ð³Ð°
		VarTable vars = VarTable.newInstance(node);

		// Ð¿Ð¾Ð»ÑƒÑ‡Ð°ÐµÐ¼ Ð¸Ð´ Ð½Ð¿Ñ�, Ðº ÐºÐ¾Ñ‚Ð¾Ñ€Ð¾Ð¼Ñƒ Ð¿Ñ€Ð¸Ð½Ð°Ð´Ð»ÐµÐ¶Ð¸Ñ‚ Ð´Ð¸Ð°Ð»Ð¾Ð³
		int id = vars.getInteger("id");
		// Ð¿Ð¾Ð»ÑƒÑ‡Ð°ÐµÐ¼ Ð¸Ð´ Ð½Ð¿Ñ�, Ðº ÐºÐ¾Ñ‚Ð¾Ñ€Ð¾Ð¼Ñƒ Ð¿Ñ€Ð¸Ð½Ð°Ð´Ð»ÐµÐ¶Ð¸Ñ‚ Ð´Ð¸Ð°Ð»Ð¾Ð³
		int type = vars.getInteger("type");

		// Ñ�Ð¾Ð·Ð´Ð°ÐµÐ¼ Ð¼Ð°Ñ�Ñ�Ð¸Ð² Ñ�Ñ�Ñ‹Ð»Ð¾Ðº
		Array<Link> links = Arrays.toArray(Link.class, 2);

		// Ð�Ð°Ñ…Ð¾Ð´Ð¸Ð¼ Ñ�Ñ�Ñ‹Ð»ÐºÐ¸ Ð¸ Ð¿Ð°Ñ€Ñ�Ð¸Ð¼ Ð¸Ñ…
		for(Node child = node.getFirstChild(); child != null; child = child.getNextSibling())
			if("link".equals(child.getNodeName()))
				links.add(parseLink(child));

		// Ñ�ÑƒÐ¶Ð°ÐµÐ¼ Ð¼Ð°Ñ�Ñ�Ð¸Ð²
		links.trimToSize();

		// Ñ�Ð¾Ð·Ð´Ð°ÐµÐ¼ Ð¸ Ð²Ð¾Ð·Ð²Ñ€Ð°Ñ‰Ð°ÐµÐ¼ Ð´Ð¸Ð°Ð»Ð¾Ð³ Ñ� ÑƒÐºÐ°Ð·Ð°Ð½Ð½Ñ‹Ñ‹Ð¼ Ð¼Ð°Ñ�Ñ�Ð¸Ð²Ð¾Ð¼ Ñ�Ñ�Ñ‹Ð»Ð¾Ðº
		return new DialogData(links.array(), id, type);
	}
}
